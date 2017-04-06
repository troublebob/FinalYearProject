<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Models\CFAssignment;

class AssignmentController extends Controller
{
	public function getAssignments(Request $request)
	{
		return response()->json(CFAssignment::all());
	}

	public function getAssignment(Request $request, $id)
	{
		return response()->json(CFAssignment::find($id));
	}

	public function viewAssignments(Request $request)
	{
		return view('assignmentlist', ['assignments' => CFAssignment::all()]);
	}

	public function viewAssignment(Request $request, $id)
	{
		return view('assignment', ['assignment' => CFAssignment::find($id)]);
	}
}