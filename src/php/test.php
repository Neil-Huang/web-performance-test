<?php

/*
访问方法：
http://localhost:8080/test/test.php?action=query&ms=1
http://localhost:8080/test/test.php?action=queryex&ms=1
*/

$ret = array();
$action = $_GET['action'];
//$action='getsig';

$ms = trim($_GET['ms']);
       
if ($ms == '') {
    $ms = 0;
}

if ($ms>0) {
	//暂停 10 秒
	usleep($ms);
}

switch ($action) {
    
    case"query";       
        try{

			$now = date('Y-m-d H:i:s');
         
            //header('content-type:application/json;charset=utf-8');
            exit($now);
        }
        catch(Exception $e){
            echo $e->getMessage();
        }

        break;


   case"queryex";
        

        try{

            $now = date('Y-m-d H:i:s');

			$objJson = new stdClass();
            $objJson-> nowtime = $now;
            $objJson-> ms = $ms;
            header('content-type:application/json;charset=utf-8');
            exit(json_encode($objJson));
        }
        catch(Exception $e){
            echo $e->getMessage();
        }

        break;


    default:
        $ret["issuccuss"] = '0';
        $ret["errorcode"] = '-1';
        $ret["errormsg"] = 'action';
        break;
}

header('content-type:application/json;charset=utf-8');
exit(json_encode($ret));

?>