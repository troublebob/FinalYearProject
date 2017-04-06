<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\CFRepo;
use Auth;

class RepoController extends Controller
{
	public function getRepos(Request $request)
	{
		$user = app("Dingo\Api\Auth\Auth")->user();
		return response()->json($user->repos);
	}

	public function getRepo(Request $request, $id)
	{
		return response()->json(CFRepo::find($id));
	}

	public function viewRepos(Request $request)
	{
		return view("repolist", ['repos' => CFRepo::all()]);
	}

	public function viewMyRepos(Request $request)
	{
		return view("repolist", ['repos' => Auth::user()->repos]);
	}
	
	public function viewRepo(Request $request, $id)
	{
		return view("repo", ['repo' => CFRepo::find($id)]);
	}

	public function postRepo(Request $request)
	{	
		$record = new CFRepo;
		$record->name = $request->input("name");
		$record->dueDate = $request->input("dueDate");
		$record->userId = $request->input("userId");
		$record->path = "storage/app/temp";
		$record->save();

		if ($request->input("assignId") == -1) {
			$record->assignId = null;
			$record->path = "storage/app/submissions/" . $request->input("userId") . "/0/" . $record->id;
		} else {
			$record->assignId = $request->input("assignId");
			$record->path = "storage/app/submissions/" . $request->input("userId") . "/" . $request->input("assignId") . "/" . $record->id;
		}
		$record->save();
		return $record->id;
		
		/*
            $table->increments('id');
            $table->string('name');
            $table->datetime('duedate');
            $table->string('path');
            $table->integer('userId')->unsigned();
            $table->integer('assignId')->unsigned();
            $table->timestamps();
		*/
	}
}
