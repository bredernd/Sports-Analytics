<?php
session_start();
require('pages/routes.php');
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sports</title>
	<?php
	echo $result[0];
	
	?>

		<?php
			
			echo $result[1]; 


			echo $result[2]; 
		?>
</body>
</html>
