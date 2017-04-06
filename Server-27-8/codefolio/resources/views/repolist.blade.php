@extends('template')

@section('title', 'My Repositories')


@section('content')

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Module</th>
				<th>Assignment</th>
				<th>Owner</th>
				<th>Submission Name</th>
				<th>Due Date</th>
				<th>Archive</th>
				<th>Comments</th>
			</tr>
		</thead>
		<tbody>
			@foreach ($repos as $repo)
			
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
						Personal Projects
					@endif
				</td>
				<td>
					{{ $repo->user->name }}
				</td>
				<td>
					<a href="{{ route("repo.view", $repo->id) }}">
						{{ $repo->name }}
					</a>
				</td>
				<td>{{ $repo->duedate }}</td>
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
