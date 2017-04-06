<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/

$api = app("Dingo\Api\Routing\Router");

$api->version("v1", function($api) {

	// login, and set token
	$api->post("login", [
		"as" => "api.login",
		"uses" => "App\Http\Controllers\AuthenticateController@authenticate"
	]);


	// modules
	$api->get("modules", [
		"middleware" => "api.auth",
		"as" => "modules.index",
		"uses" => "App\Http\Controllers\ModuleController@getModules"
	]);

	$api->post("modules", [
		"middleware" => "api.auth",
		"as" => "modules.create",
		"uses" => "App\Http\Controllers\ModuleController@postModule"
	]);


	// comments
	$api->get("comments", [
		"middleware" => "api.auth",
		"as" => "comments.index",
		"uses" => "App\Http\Controllers\CommentController@getComments"
	]);
	$api->post("comment", [
		"middleware" => "api.auth",
		"as" => "comments.create",
		"uses" => "App\Http\Controllers\CommentController@postComment"
	]);


	// repos
	$api->post("repo", [
		"middleware" => "api.auth",
		"as" => "repos.create",
		"uses" => "App\Http\Controllers\RepoController@postRepo"
	]);
	$api->get("repos", [
		"middleware" => "api.auth",
		"as" => "repos.index",
		"uses" => "App\Http\Controllers\RepoController@getRepos"
	]);
	
	
	// file upload
	$api->post("archive", [
		"middleware" => "api.auth",
		"as" => "archive.create",
		"uses" => "App\Http\Controllers\ArchiveController@postArchive"
	]);

});


// login
Route::get("login", function() {
    return view("login");
});

Route::post("login", [
	"as" => "login.post",
	"uses" => "AuthenticateController@webAuthenticate"
]);

// logout
Route::get("logout", [
	"as" => "logout",
	"middleware" => "auth",
	"uses" => "AuthenticateController@logout"
]);

Route::get("/", [
	"middleware" => "auth",
	"as" => "home",
	function() {
		return redirect()->route("repos.myindex");
	}
]);

// repo views
Route::get("repos", [
	"middleware" => "auth",
	"as" => "repos.index",
	"uses" => "RepoController@viewRepos"
]);

Route::get("myrepos", [
	"middleware" => "auth",
	"as" => "repos.myindex",
	"uses" => "RepoController@viewMyRepos"
]);

Route::get("repo/{id}", [
	"middleware" => "auth",
	"as" => "repo.view",
	"uses" => "RepoController@viewRepo"
]);


// assignment views
Route::get("assignments", [
	"middleware" => "auth",
	"as" => "assignments.index",
	"uses" => "AssignmentController@viewAssignments"
]);

Route::get("assignment/{id}", [
	"middleware" => "auth",
	"as" => "assignment.view",
	"uses" => "AssignmentController@viewAssignment"
]);


// module views
Route::get("modules", [
	"middleware" => "auth",
	"as" => "modules.index",
	"uses" => "ModuleController@viewModules"
]);

Route::get("module/{id}", [
	"middleware" => "auth",
	"as" => "module.view",
	"uses" => "ModuleController@viewModule"
]);


// comments views
Route::post("comment", [
	"middleware" => "auth",
	"as" => "comments.create",
	"uses" => "CommentController@postWebComment"
]);


// file storage
Route::get("getAssignment/{id}", [
	"middleware" => "auth",
	"as" => "storage.assignment",
	"uses" => "ArchiveController@getAssignment"
]);

Route::get("getSubmission/{path}", [
	"middleware" => "auth",
	"as" => "storage.submission",
	"uses" => "ArchiveController@getSubmission"
]);
