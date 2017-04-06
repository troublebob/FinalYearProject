<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\CFModule;

class ModuleController extends Controller
{
	public function getModules(Request $request)
	{
		return response()->json(CFModule::with("assignments")->get());
	}

	public function getModule(Request $request, $id)
	{
		return response()->json(CFModule::all());
	}

	public function viewModules(Request $request)
	{
		return view("modulelist", ["modules" => CFModule::all()]);
	}

	public function viewModule(Request $request, $id)
	{
		return view("module", ["module" => CFModule::find($id)]);
	}

	public function postModule(Request $request)
	{

		$modulerecord = new CFModule;
		$modulerecord->id = $request->input("id");
		$modulerecord->code = $request->input("code");
		$modulerecord->description = $request->input("description");
		$modulerecord->lecturer = $request->input("lecturer");
		$modulerecord->save();

		return response()->json([
			"success" => true,
		]);
	}
}