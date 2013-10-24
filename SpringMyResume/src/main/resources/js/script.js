                                      
$(document).ready(function() {


   $("#experiencetable th").mouseenter(function () { 

      $(this).parents("table#experiencetable").find("td").slideDown();
	

   });
   $("#experiencetable th").click(function () { 

      $(this).parents("table#experiencetable").find("td").slideUp();
	

   });



});

