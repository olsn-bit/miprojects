import cx_Freeze
import os.path
PYTHON_INSTALL_DIR = os.path.dirname(os.path.dirname(os.__file__))
os.environ['TCL_LIBRARY'] = os.path.join(PYTHON_INSTALL_DIR, 'tcl', 'tcl8.6')
os.environ['TK_LIBRARY'] = os.path.join(PYTHON_INSTALL_DIR, 'tcl', 'tk8.6')
executables = [cx_Freeze.Executable("Ecliono Alpha.py", base = "Win32GUI")]
cx_Freeze.setup(
    name="Ecliono Alpha",
    options={"build_exe": {"packages":["pygame","random"],"include_files":["images/fondo1.png","images/fondo2.png","images/fondo3.png","images/fondo4.png","images/fondo5.png","images/PJ.png","images/PJ1.png","images/PJ2.png","images/PJ2x.png","images/PJ12.png","images/PJ22.png","images/squarefondo1.1.jpg"]}},
    executables = executables)
