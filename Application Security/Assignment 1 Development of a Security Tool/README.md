1. Built-in Python Libraries
These libraries come with Python as pre-configured, so no installation is needed:
Libraries (pre-configured):
-   os (file path operations and environment variable handling)
-	json (reading and saving user accounts to a JSON file)
-	re (username validation using regular expressions)
-	string (removing punctuation during text cleaning)

2. External libraries (installation is needed):
These libraries must be installed manually because they are not pre-configured in Python:
-	bcrypt (secure hashing of user passwords)
-	python-dotenv (loads the OpenAI API key from a .env file)
-	openai (sends email text to the GPT model for phishing analysis)

command to install external libraries:
pip install bcrypt python-dotenv openai
