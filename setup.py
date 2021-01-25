__author__ = '' #Tu nombre o el del autor
# Let's start with some default (for me) imports...
import sys
from cx_Freeze import setup, Executable


build_exe_options = {
"include_msvcr": True   #skip error msvcr100.dll missing
}
# Process the includes, excludes and packages first

carpeta = ''  #nombre de la carpeta donde se instalara el programa

if 'bdist_msi' in sys.argv:
    sys.argv += ['--initial-target-dir', 'C:\Program File\\ ' + carpeta]

includes = [''] #librerias que lleva tu proyecto separadas por comas entre comillas
excludes = []
packages = []
path = []
include_files = [''] #carpetas que lleva tu aplicacion separadas por comas entre comillas
include_msvcr = ['networkChanger.exe.manifest']

if sys.platform == 'win32':
    base = 'Win32GUI'
if sys.platform == 'linux' or sys.platform == 'linux2':
    base = None

sico = Executable(
    # what to build
    script = "", #archivo que ejecuta todo el programa
    initScript = None,
    base = base,
    compress = True,
    copyDependentFiles = True,
    appendScriptToExe = True,
    appendScriptToLibrary = True,
    icon = '', #ruta del icono del programa
    #shortcutName="DHCP",
    #shortcutDir="ProgramMenuFolder"
    )

setup(

    version = "", # version
    description = "", #pequeña descripcion
    author = "", #autor
    name = "", #nombre del programa

    options = {"build_exe": {"includes": includes,
                 "excludes": excludes,
                 "packages": packages,
                 "path": path,
                 "include_files": include_files,
                 "include_msvcr": include_msvcr,

                 }
           },

    executables=[sico]
    )
