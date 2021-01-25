<!DOCTYPE html>
<html lang="en">
   <head>
      <link rel="stylesheet" type="text/css" href="gestioempleats.css">
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>PagSplit1</title>
   </head>
   <body>
      <div id="head">
         <h1 id="h1">Gestió empresarial Montsià</h1>
         <h2 id="h2">Gestió de empleats</h2>
      </div>
      <div id="borde">
        
         <div style="width:80%;"id="cajon2">
            <form id="formulari" action="gestioempleats.php" method="get">
<p>Nombre: <input type="text" name="nom" size="10" placeholder="Alfreds" > </p>
    <p>DNI: <input type="text" name="dni" size="14" placeholder="89234117C" >
      Sexe: <input type="text" name="sexe" size="14" placeholder="Home" >
<div id ="imagfons">
                  <img id="img"src="images/imagEmpleat.png" alt="empleatimag">
               </div>
    </p>
    <p id="Nsscs">NSS: <input type="text" name="nss"  size="14" placeholder="ALFR 000123223" ></p>
    <p id="adminU">Rol: <input type="text" name="rol"  size="14" placeholder="Admin" ></p>
               <p id="botons">
                  <input type="submit" value="Guardar">
               </p>
            </form>
         </div>
      </div>
   </body>
</html>