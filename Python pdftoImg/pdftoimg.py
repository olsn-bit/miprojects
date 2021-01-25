
from pdf2image import convert_from_path
import os
inputdir = "G:\Marina"
for fichier in os.listdir(inputdir):
    
    file = inputdir + "\\" + fichier
    
    print("converting "+file)
    pages = convert_from_path(file, 500)
