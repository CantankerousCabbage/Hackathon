# Import the module
import json
import collections.abc
import pandas as pd

# Opens JSON file as a DICT
# with open('AutoClave5 JSON Files\AC2-07337-anon.json', 'r') as f:
#     data = json.load(f)

with open('Matt/test_matt2.json' , 'r') as f:
    data = json.load(f)

#JSON are loaded as a DICT in python 3.11
print(type(data))

#Create a DICT search query
# for key in data.keys():
#     print("the key is {} and the value is {}".format(key, data[key]))


#Function to flatten the dictionary
# def flatten(d, parent_key='', sep='_'):
#     items = []
#     for k, v in d.items():
#         new_key = parent_key + sep + k if parent_key else k
#         if isinstance(v, collections.abc.MutableMapping):
#             items.extend(flatten(v, new_key, sep=sep).items())
#         else:
#             items.append((new_key, v))
#     return dict(items)

# flattenedDict = flatten(data)
# print(flattenedDict)

#print(data)

flatDictionary = pd.json_normalize(data)
print(flatDictionary.to_string())
#Write output to text file
with open('Matt/test_matt2.txt', 'w') as f:
    f.write(str(flatDictionary.to_string()))


import pandas as pd

# enter the json filename to be converted to json
JSON_FILE = data

# enter the csv filename you wish to save it as
CSV_FILE = 'csv_filename.csv'

with open(JSON_FILE, encoding = 'utf-8') as f :
	df = pd.read_json(f)
    
df.to_csv(CSV_FILE, encoding = 'utf-8', index = False)