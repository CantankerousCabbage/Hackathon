# pip install json2html

from json2html import *

input = {
        "name": "json2html",
        "description": "Converts JSON to HTML tabular representation"
}

output = json2html.convert(json = input)

print(output)
print(type(output))