<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class CFRepo extends Model
{
    protected $table = 'repos';

    public function user()
    {
    	return $this->belongsTo('App\Models\CFUser', 'userId');
    }

    public function assignment()
    {
		if ($this->assignId != Null) {
			return $this->belongsTo('App\Models\CFAssignment', 'assignId');
		}
		return Null;
	}

    public function comments()
    {
    	return $this->hasMany('App\Models\CFComment', 'repoId');
    }
}
