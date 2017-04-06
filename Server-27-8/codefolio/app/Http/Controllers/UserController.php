<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\user;

class userController extends Controller
{
	public function authenticationCheck(Request $request)
	{
		//return checkPassword($request);
		$user = new user;
		$query = $user->checkPassword($request);
		
		if($query->isEmpty()){
			return $request;
		}else{
			return $query->input('userid');
		}
		//return $request->input("email");
	}
}