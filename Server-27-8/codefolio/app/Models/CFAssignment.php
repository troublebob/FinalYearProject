<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class CFAssignment extends Model
{
    protected $table = 'assignments';

    public function module()
    {
    	return $this->belongsTo('App\Models\CFModule', 'moduleId');
    }

    public function repos()
    {
    	return $this->hasMany('App\Models\CFRepo', 'assignId');
    }
}
