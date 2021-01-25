<footer class="page-footer mt-auto py-3 bg-dark">

<?php switch ($footer ?? 0):
  case 0:?>
  <!-- Footer -->
    <!-- Footer Links -->
    <div class="container text-white text-center text-md-left mt-5">

      <!-- Grid row -->
      <div class="row mt-3">

        <!-- Grid column -->
        <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">

          <!-- Content -->
          <h6 class="text-uppercase font-weight-bold">UniProject</h6>
          <hr class="bg-light accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
          <p>Nosaltres creiem en les teves capacitats i per això et facilitem les eines
            per a la creació de propostes i projectes conjuntament amb altres empreses i centres.</p>

        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

          <!-- Links -->
          <h6 class="text-uppercase  font-weight-bold">Productes</h6>
          <hr class="bg-light accent-2  mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
          <p><i class="text-white" href="#!">Disseny Web</i></p>
          <p><i class="text-white" href="#!">Programació Web</i></p>
          <p><i class="text-white" href="#!">Desenvolupament d'aplicacions Web</i></p>

        </div>

        <!-- Grid column -->
        <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

          <!-- Links -->
          <h6 class="text-uppercase font-weight-bold">Contacta'ns</h6>
          <hr class="bg-light accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
          <p><i class="fa fa-home mr-3"></i> Amposta 43870, C/Madrid, Nº35, Espanya</p>
          <p><i class="fa fa-envelope mr-3"></i> UniProject@gmail.com</p>
          <p><i class="fa fa-phone mr-3"></i> +34 977 70 00 43</p>

        </div>
        <!-- Grid column -->

      </div>
      <!-- Grid row -->

    </div>
    <!-- Footer Links -->

    <!-- Copyright -->
    <div class="text-white footer-copyright text-center py-3">© 2021
      <!-- <a class="text-light" href="/Sprint3DAW-grup3/Grup3/template/PoliticaPrivacitat.pdf"> Tots els drets reservats |</a> -->
    </div>
    <!-- Copyright -->

<?php break;
  case 1: ?>
  <!-- Alternative footer here -->

<?php break;
  endswitch;
  unset($footer); ?>

</footer>
<script src="/Sprint3DAW-grup3/Grup3/js/jquery/jquery-3.5.1.min.js"></script>
<script src="/Sprint3DAW-grup3/Grup3/js/custom.js"></script>
