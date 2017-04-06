@extends('template')

@section('title', 'Assignment View')


@section('content')

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Module</th>
				<th>Assignment Name</th>
				<th>Description</th>
				<th>Archive</th>
			</tr>
		</thead>
		<tbody>
			@foreach ($assignments as $assignment)
			
			<tr>
				<td>
					<a href="{{ route("module.view", $assignment->module->id) }}">
						{{ $assignment->module->code }}
					</a>
				</td>
				<td>{{ $assignment->name }}</td>
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
