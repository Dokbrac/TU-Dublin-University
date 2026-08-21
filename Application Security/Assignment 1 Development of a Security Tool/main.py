"""
AI Phishing Detection Tool
Author: Csaba Palosi
21/11/2025

main.py:
- handles LOGIN and MAIN MENU
- allows local or GPT-based analysis for phishing emails
- everything in a single file for submission as requested
"""

import os
import json
import re
import string
import bcrypt
from dotenv import load_dotenv
from openai import OpenAI

# --- Load environment variables from .env ---
load_dotenv()  # load key/value pairs from .env into the app
OPENAI_API_KEY = os.getenv("OPENAI_API_KEY", "").strip()  # get API key from env and remove extra spaces

# --- Users file ---
USERS_FILE = os.path.join(os.path.dirname(os.path.abspath(__file__)), "users.json") # path to users.json in same directory as main.py

# --- Password functions ---
def hash_password(password: str) -> str:  # hash a password by bcrypt
    return bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()  # encode password to bytes then hash with salt and decode back to a string

def verify_password(password: str, hashed: str) -> bool:  # verify a password against a bcrypt hash
    return bcrypt.checkpw(password.encode(), hashed.encode())  # encode both the input password and the stored hash and compare them securely

# --- User functions ---
def save_users(users):  # save the user into the users.json file
    with open(USERS_FILE, "w", encoding="utf-8") as x:
        json.dump(users, x, indent=4)  # write the users list to JSON file

def load_users():  # load the user list from users.json
    if not os.path.exists(USERS_FILE):
        save_users([])
        return []  # create an empty JSON if missing and return the empty list
    with open(USERS_FILE, "r", encoding="utf-8") as x:
        return json.load(x)  # return the users from the JSON file

def delete_user(username):  # delete a user by username from users.json
    users = load_users()  # load current users
    updated_users = [user for user in users if user["username"] != username]  # create a new list excluding the specified username
    if len(updated_users) == len(users):
        return False  # if the lengths are the same no user deleted
    save_users(updated_users)
    return True  # save the updated list back to JSON if deletion successful

# --- Email functions ---
def load_email(path):  # load email text from a file; can be relative or absolute path
    if not path:
        print("File path cannot be empty!")
        return None  # if no path provided, stop

    base_dir = os.path.dirname(os.path.abspath(__file__))  # get directory of this script
    abs_path = os.path.join(base_dir, path) if not os.path.isabs(path) else path  # convert relative path to absolute, leave absolute as it is

    try:
        with open(abs_path, "r", encoding="utf-8") as x:
            return x.read()  # read the entire email file and return it as string
    except FileNotFoundError:
        print(f"File not found: {abs_path}")
        return None  # handle missing file
    except Exception as e:
        print("Error reading file:", e)
        return None  # handle other file errors

# --- LOCAL ANALYSIS ---
def clean_text(text):  # convert the text to lowercase and remove all punctuation from it
    return text.lower().translate(str.maketrans('', '', string.punctuation))

def analyze_email_local(email_text):  # keyword-based phishing scan and returns a dictionary with the result
    suspicious_keywords = [
        "verify", "password", "click", "urgent", "account", "suspend",
        "confirm", "credentials", "login", "security", "reset",
        "immediately", "warning", "alert",
        "invoice", "payment", "refund", "transaction",
    ]  # list of words often used in phishing emails for the local scan

    score = 0  # score starting value
    cleaned = clean_text(email_text)  # clean the email text

    for word in suspicious_keywords:
        if word in cleaned:
            score += 1  # increment score if keyword found in the list

    suspicious = score > 2  # flag as suspicious if more than 2 keyword found

    return {
        "method": "Local",  # type of the scan
        "length": len(email_text),  # length of the email
        "suspicious_score": score,  # number of suspicious keywords
        "suspicious": suspicious  # boolean to display if the email suspicious or not (TRUE or FALSE)
    }

# --- GPT/OPENAI ANALYSIS ---
def analyze_email_gpt(email_text):  # GPT-3.5-Turbo OpenAI API phishing scan and returns a dictionary with the result of GPT analysis or error
    if not OPENAI_API_KEY:
        return {"method": "GPT/OpenAI", "error": "OpenAI API key not found."}  # if API key is missing, stop

    client = OpenAI(api_key=OPENAI_API_KEY)  # create the OpenAI API client

    # create prompt for phishing analysis
    prompt = (
        "Analyze the following email text and determine if it is a phishing attempt.\n"
        "Provide a confidence score (0-100) and explain why.\n\n"
        f"Email Text:\n{email_text}"
    )

    try:
        response = client.chat.completions.create(
            model="gpt-3.5-turbo",  # specify which GPT model to use
            messages=[{"role": "user", "content": prompt}],  # send prompt as the user message
            temperature=0  # deterministic output
        )

        answer = response.choices[0].message.content  # get GPT response in text

        return {
            "method": "GPT/OpenAI",  # type of the scan
            "length": len(email_text),  # length of the email
            "analysis": answer  # GPT analysis of email
        }

    except Exception as e:
        return {"method": "GPT/OpenAI", "error": f"GPT Error: {e}"}  # if API call fails, return an error message

# --- REPORT ---
def print_report(result):  # print formatted report for local or GPT analysis
    print("\n--- Analysis Result ---")
    print(f"Method: {result.get('method', 'Unknown')}")  # print the method
    print(f"Length: {result.get('length', 'N/A')}")  # print the length of the email

    if result.get('method') == "Local":
        # local analysis: show score and suspicious flag
        print(f"Suspicious Score: {result.get('suspicious_score', 'N/A')}")
        print(f"Suspicious: {result.get('suspicious', 'N/A')}")

    elif result.get('method') == "GPT/OpenAI":
        if 'error' in result:
            # GPT API error handling
            print(f"Error: {result['error']}")
        else:
            # print GPT analysis output
            print(f"Analysis:\n{result.get('analysis', '')}")

    print("-----------------------\n")  # end of the report

# --- AUTH FUNCTIONS ---
def register():  # user registration with validation and password hashing
    users = load_users()  # load existing users from users.json
    username = input("Enter new username: ").strip()  # input for username and remove spaces at end

    # username validation
    if not username:
        print("Username cannot be empty!\n")
        return None  # if the username empty, stop the registration
    if " " in username:
        print("Username cannot contain spaces!\n")
        return None  # if spaces in the username, stop the registration
    if len(username) < 3 or len(username) > 20:
        print("Username must be 3-20 characters long!\n")
        return None  # if username too short or too long, stop the registration
    if not re.match("^[A-Za-z0-9_]+$", username):
        print("Username can only contain letters, numbers, and underscores!\n")
        return None  # if invalid characters used, stop the registration

    if any(x["username"] == username for x in users):
        print("Username already exists.\n")
        return None  # if username already exists, stop the registration

    # --- Password ---
    password = input("Enter new password: ").strip()  # input for password
    if not password:
        print("Password cannot be empty!\n")
        return None  # if password is empty, stop the registration

    hashed = hash_password(password)  # hash the password by bcrypt
    users.append({"username": username, "password": hashed})  # add the user to the list
    save_users(users)  # save updated list to users.json
    print("Registration successful!\n")
    return username  # return the new username

def login():  # user login by verifying with the stored credentials
    users = load_users()  # load the existing users
    username = input("Username: ").strip()  # input username
    password = input("Password: ").strip()  # input password
    if not username or not password:
        print("Username and password cannot be empty!\n")
        return None  # if username or password is empty, stop the login

    for user in users:
        if user["username"] == username and verify_password(password, user["password"]):
            print("Login successful!\n")
            return username  # login if username exists and password matches

    print("Invalid username or password.\n")
    return None  # login failed if username exists and password matches do not match

# --- MAIN MENU ---
def user_menu(current_user):  # loop to display main menu until logout or choose an option
    while True:
        print("\n--- MENU ---")
        print("1. Analyze email (Local)")
        print("2. Analyze email (GPT/OpenAI)")
        print("3. Delete Account")
        print("4. Logout")
        choice = input("Choose: ").strip()  # input from user to choose and remove extra space

        # option 1: local email analysis
        if choice == "1":
            while True:  # loop for analysing multiple emails
                email_file_path = input(
                    "Enter email file path (e.g., samples/malicious_email.txt or normal_email.txt) or 'back' to return: "
                ).strip()
                if email_file_path.lower() == 'back':  # if path is typed as back, go back to main menu
                    break
                email_text = load_email(email_file_path)
                if email_text:
                    result = analyze_email_local(email_text)
                    print_report(result)

        # option 2: GPT/OpenAI email analysis
        elif choice == "2":
            while True:
                email_file_path = input(
                    "Enter email file path for GPT (e.g., samples/malicious_email.txt or normal_email.txt) or 'back' to return: "
                ).strip()
                if email_file_path.lower() == 'back':
                    break
                email_text = load_email(email_file_path)
                if email_text:
                    result = analyze_email_gpt(email_text)
                    print_report(result)

        # option 3: delete account
        elif choice == "3":
            confirm = input("Are you sure you want to delete your account? (yes/no): ").strip().lower()
            if confirm == "yes":
                if delete_user(current_user):
                    print(f"User '{current_user}' deleted successfully.\n")
                    break
                else:
                    print("Error: user not found.\n")
            else:
                print("Account deletion canceled.\n")

        # option 4: logout
        elif choice == "4":
            print("Logged out.\n")
            break

        # invalid input handling
        else:
            print("Invalid option.\n")  # display invalid option

# --- LOGIN MENU ---
def main():  # loop to display login menu until exit or choose an option
    print("--- Welcome to AI Phishing Detection Tool! ---\n")

    while True:
        print("1. Login")
        print("2. Register")
        print("3. Exit")
        choice = input("Choose: ").strip()

        if choice == "1":
            user = login()
            if user:
                user_menu(user)
        elif choice == "2":
            user = register()
            if user:
                user_menu(user)
        elif choice == "3":
            print("Exiting program.")
            break
        else:
            print("Invalid option.\n")

# start the program if this file is run directly
if __name__ == "__main__":
    main()
