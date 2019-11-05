<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

require_once('config.php');

$response = array();

$merk = htmlentities($_POST['merk']);
$ukuran = htmlentities($_POST['ukuran']);

$sql = "INSERT INTO tb_kemeja VALUES ('', '$merk', '$ukuran')";

$query = mysqli_query($conn, $sql);

if($query) {
    $response = array(
        'status' => 'Success',
        'message' => 'Data berhasil ditambahkan.'
    );
} else {
    $response = array(
        'status' => 'Failed',
        'message' => 'Data gagal ditambahkan.'
    );
}

http_response_code(200);

echo json_encode($response);