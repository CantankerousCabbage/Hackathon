# Import the module
import json

# Opens JSON file as a DICT
with open('AutoClave5 JSON Files\AC2-07337-anon.json', 'r') as f:
    data = json.load(f)


print(type(data))
