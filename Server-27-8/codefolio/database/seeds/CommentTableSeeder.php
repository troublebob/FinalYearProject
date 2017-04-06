<?php

use Illuminate\Database\Seeder;

class CommentTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table("comments")->delete();

        // DB::table("comments")->insert([
        //     "id" => 1,
        //     "authorId" => 2,
        //     "repoId" => 1,
        //     "comment" => "Good work buddy :D",
        // ]);

        // DB::table("comments")->insert([
        //     "id" => 2,
        //     "authorId" => 2,
        //     "repoId" => 1,
        //     "comment" => "This is another line comment",
        // ]);
    }
}
