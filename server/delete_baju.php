<?php
   require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='POST') {
   $id_kemeja = $_POST['id_kemeja'];
  $result = mysqli_query($conn,"SELECT * FROM tb_kemeja where id_kemeja='$id_kemeja'") or die(mysqli_error());
  if (mysqli_num_rows($result) > 0){
      $sql = "DELETE FROM tb_kemeja WHERE id_kemeja = '$id_kemeja'";
     if(mysqli_query($conn,$sql)) {
       $response["success"] = 1;
       $response["message"] = "Berhasil";
       echo json_encode($response);
     } else {
       $response["success"] = 0;
       $response["message"] = "Gagal";
       echo json_encode($response);
     }
  }else{
       $response["success"] = 0;
       $response["message"] = "Data tidak ada";
       echo json_encode($response);
  }
   mysqli_close($conn);
  } else {
    $response["success"] = 0;
    $response["message"] = "Error";
    echo json_encode($response);
  }
?>