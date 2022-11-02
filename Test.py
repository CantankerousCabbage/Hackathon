import webbrowser
import os

f = open('GFG.html', 'w')

html = '''<!DOCTYPE html>
<html>
<body>

<h1>My First Heading</h1>
<p>My first paragraph.</p>

</body>
</html>'''



f.write(html)
  
# close the file
f.close()
  
# 1st method how to open html files in chrome using
filename = 'file:///'+os.getcwd()+'/' + 'GFG.html'
webbrowser.open_new_tab(filename)