@extends('template')

@section('title', 'Assignment View')


@section('content')

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Code</th>
				<th>Lecturer</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			@foreach ($modules as $module)
			
			<tr>
				<td>
					@if ($module->id != 1)
						<a href="{{ route("module.view", $module->id) }}">
							{{ $module->code }}
						</a>
					@else
						{{ $module->code }}
					@endif
				</td>
				<td>{{ $module->lecturer }}</td>
				<td>{{ $module->description }}</td>
			</tr>

			@endforeach
		</tbody>
	</table>

@stop		
