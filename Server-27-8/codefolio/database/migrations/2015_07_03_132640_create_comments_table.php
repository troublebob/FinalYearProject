<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateCommentsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('comments', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('authorId')->unsigned();
            $table->integer('repoId')->unsigned();
            $table->string('comment');
            $table->timestamps();

            $table->foreign('authorId')->references('id')->on('users')->onDelete('cascade');
            $table->foreign('repoId')->references('id')->on('repos')->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::drop('comments');
    }
}
