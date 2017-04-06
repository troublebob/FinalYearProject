@extends('template')

@section('title', 'Assignment View')


@section('content')

	<a href="{{ route("modules.index") }}">
		Return to module list
	</a>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Code</th>
				<th>Lecturer</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>{{ $module->code }}</td>
				<td>{{ $module->lecturer }}</td>
				<td>{{ $module->description }}</td>
			</tr>
		</tbody>
	</table>

	@if ($module->id != 1)
		<h4>Assignments for "{{ $module->code }}"</h4>
	@else
		<h4>Repos in "{{ $module->code }}"</h4>
	@endif

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Assignment Name</th>
				<th>Description</th>
				<th>Archive</th>
			</tr>
		</thead>
		<tbody>
			@foreach ($module->assignments as $assignment)
			
			<tr>
				<td>
					<a href="{{ route("assignment.view", $assignment->id) }}">
						{{ $assignment->name }}
					</a>
				</td>
				<td>{{ $assignment->description }}</td>
				<td>
					<a href="{{ route("storage.assignment", ["id" => $assignment->id, "path" => $assignment->path]) }}">
						Download <span class="glyphicon glyphicon-download-alt"></span>
					</a>
				</td>
			</tr>

			@endforeach
		</tbody>
	</table>

@stop		
