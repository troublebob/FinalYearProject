@extends('template')

@section('title', 'My Repositories')


@section('content')

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Module</th>
				<th>Assignment</th>
				<th>Submission Name</th>
				<th>Due Date</th>
				<th>Archive</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					@if ($repo->assignId)
						<a href="{{ route("module.view", $repo->assignment->module->id) }}">
							{{ $repo->assignment->module->code }}
						</a>
					@else
						-
					@endif
				</td>
				<td>
					@if ($repo->assignId)
						<a href="{{ route("assignment.view", $repo->assignId) }}">
							{{ $repo->assignment->name }}
						</a>
					@else
						-
					@endif
				</td>
				<td>{{ $repo->name }}</td>
				<td>{{ $repo->duedate }}</td>
				<td>
					<a href="{{ route("storage.submission", $repo->path) }}">
						Download <span class="glyphicon glyphicon-download-alt"></span>
					</a>
				</td>
			</tr>
		</tbody>
	</table>

	<h4>Comments for "{{ $repo->name }}"</h4>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Author</th>
				<th>Comment</th>
				<th>Comment Date</th>
			</tr>
		</thead>
		<tbody>
			@foreach ($repo->comments as $comment)

			<tr>
				<td>{{ $comment->author->name }}</td>
				<td>{{ $comment->comment }}</td>
				<td>{{ $comment->created_at }}</td>
			</tr>

			@endforeach
		</tbody>
	</table>

	<h4>New Comment</h4>
	<form action="{{ route("comments.create") }}" method="POST">
		<input type="hidden" name="repoId" value="{{ $repo->id }}" />
	
		<div class="form-group">
			<textarea name="comment" class="form-control" rows="2">Great Work!</textarea>
		</div>
		
		<div class="form-group">
			<button type="submit" class="btn btn-default">Add Comment</button>
		</div>
	</form>		
	
@stop		
