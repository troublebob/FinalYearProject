<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;
use App\Http\Controllers\Controller;
use Storage;
use Auth;

class ArchiveController extends Controller
{
	public function postArchive(Request $request)
	{
		$user = app("Dingo\Api\Auth\Auth")->user();
		
		if ($request->hasFile("archive")) {
			if ($request->file("archive")->isValid()) {
				Storage::makeDirectory((string)$user->id);
				
				$new_path = storage_path() . "/app/submissions/" . (string)($user->id);
				$new_filename = $request->file("archive")->getClientOriginalName();
				
				$request->file("archive")->move($new_path, $new_filename);
				
				return response()->json(["success" => true]);
			}
			return response()->json(["success" => false, "error" => "Invalid file"]);

		} else {

			return response()->json(["success" => false, "error" => "No file present"]);
		}

		return response()->json($request->all());
	
	
		//if ($request->hasFile('photo')) {
		//}
		
		//Validating Successful Uploads
		//In addition to checking if the file is present, you may verify that there were no problems uploading the file via the isValid method:

		//if ($request->file('photo')->isValid()) {
		//}
		
		//Moving Uploaded Files
		//To move the uploaded file to a new location, you should use the move method. This method will move the file from its temporary upload location (as determined by your PHP configuration) to a more permanent destination of your choosing:

		//$request->file('photo')->move($destinationPath);
		//$request->file('photo')->move($destinationPath, $fileName);
		
	}

	public function getSubmission(Request $request, $filename)
	{
		$path = realpath(storage_path() . "/app/submissions/" . (string)(Auth::user()->id) . "/" . $filename);
		return response()->download($path, $filename);
	}

	public function getAssignment(Request $request, $id)
	{
		$directory = realpath(storage_path() . "/app/assignments/" . (string)($id));
		$files = scandir($directory);
		foreach ($files as $filename) {
			if ($filename && $filename != "." && $filename != "..") {
				$path = realpath($directory . "/" . $filename);
				return response()->download($path, $filename);
			}
		}
	}
}
