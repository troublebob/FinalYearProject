<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\CFComment;
use Auth;

class CommentController extends Controller
{
	public function postComment(Request $request)
	{		
		//return response()->json($request->all());

		$commentrecord = new CFComment;
		$commentrecord->authorId = $request->input("authorId");
		$commentrecord->repoId = $request->input("repoId");
		$commentrecord->comment = $request->input("comment");
		$commentrecord->save();

		return $commentrecord->id;
	}

	public function postWebComment(Request $request)
	{		
		$commentrecord = new CFComment;
		$commentrecord->authorId = Auth::user()->id;
		$commentrecord->repoId = $request->input("repoId");
		$commentrecord->comment = $request->input("comment");
		$commentrecord->save();

		return redirect()->route("repo.view", $request->input("repoId"));
	}
}