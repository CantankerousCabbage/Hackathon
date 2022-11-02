# pip install json2html

from json2html import *

input = {
        "name": "json2html",
        "description": "Converts JSON to HTML tabular representation"
}

output = json2html.convert(json = input)

print(output)
print(type(output))

f = open("cure_file.html", "a")
f.write("Now the file has more content!")
f.close()