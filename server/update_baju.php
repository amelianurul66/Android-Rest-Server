<?php
   require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='POST') {
   $id_kemeja = $_POST['id_kemeja'];
   $merk = $_POST['merk'];
   $ukuran = $_POST['ukuran'];
     $sql = "UPDATE tb_kemeja SET merk = '$merk', ukuran ='$ukuran' WHERE id_kemeja = '$id_kemeja'";
     if(mysqli_query($conn,$sql)) {
       $response["success"] = 1;
       $response["message"] = "Berhasil";
       echo json_encode($response);
     } else {
       $response["success"] = 0;
       $response["message"] = "Gagal";
       echo json_encode($response);
     }
   mysqli_close($con);
  } else {
    $response["success"] = 0;
    $response["message"] = "Error";
    echo json_encode($response);
  }
?>