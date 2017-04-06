<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class CFModule extends Model
{
    protected $table = 'modules';

    public function students()
    {
    	return $this->belongsToMany('App\Models\CFUser', 'user_modules', 'moduleId', 'userId');
    }

    public function assignments()
    {
    	return $this->hasMany('App\Models\CFAssignment', 'moduleId');
    }
}
