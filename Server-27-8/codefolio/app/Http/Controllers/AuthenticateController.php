<?php

namespace App\Http\Controllers;

use JWTAuth;
use Tymon\JWTAuth\Exceptions\JWTException;

use Auth;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class AuthenticateController extends Controller
{
	public function authenticate(Request $request)
	{		
		$credentials = $request->only("email", "password");

		try {

			if (! $token = JWTAuth::attempt($credentials)) {
                return response()->json(['error' => 'invalid_credentials'], 401);
            }

        } catch (JWTException $e) {
            
            return response()->json(['error' => 'could_not_create_token'], 500);
        }

        return response()->json(compact('token'));
    }
	
	public function webAuthenticate(Request $request)
	{		
		$credentials = $request->only("email", "password");

		if (Auth::attempt($credentials)) {
			return redirect("myrepos");
		}

        return redirect("login")->withInput($request->except("password"));
    }
	
	public function logout(Request $request)
	{
		Auth::logout();
		
		return redirect("login");
	}
	
}