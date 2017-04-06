@extends('template')

@section('title', 'Assignment View')


@section('content')

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Module</th>
				<th>Assignment Name</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
		
			<td>
				<a href="{{ route("module.view", $assignment->moduleId) }}">
					{{ $assignment->moduleId }}
				</a>
			</td>
			<td>{{ $assignment->name }}</td>
			<td>{{ $assignment->description }}</td>
			
		</tbody>
	</table>

	<h4>Submissions for "{{ $assignment->name }}"</h4>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Owner</th>
				<th>Submission Name</th>
				<th>Archive</th>
				<th>Comments</th>
			</tr>
		</thead>
		<tbody>
			@foreach ($assignment->repos as $repo)
			
			<tr>
				<td>
					{{ $repo->user->name }}
				</td>
				<td>
					<a href="{{ route("repo.view", $repo->id) }}">
						{{ $repo->name }}
					</a>
				</td>
				<td>
					<a href="{{ route("storage.submission", $repo->path) }}">
						Download <span class="glyphicon glyphicon-download-alt"></span>
					</a>
				</td>
				<td>{{ $repo->comments->count() }}</td>
			</tr>

			@endforeach
		</tbody>
	</table>
	
@stop		
