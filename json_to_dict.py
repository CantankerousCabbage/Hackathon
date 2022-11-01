# Import the module
import json

# String with JSON format
with open('AutoClave5 JSON Files\AC2-07337-anon.json', 'r') as f:
    data = json.load(f)

    # Convert JSON string to dictionary
    #data_dict = json.load(data)

print(data)
