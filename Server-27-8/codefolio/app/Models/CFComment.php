<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class CFComment extends Model
{
    protected $table = 'comments';

    public function author()
    {
    	return $this->belongsTo('App\Models\CFUser', 'authorId');
    }

    public function repo()
    {
    	return $this->belongsTo('App\Models\CFRepo', 'repoId');
    }
}
