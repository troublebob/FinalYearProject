<?php

use Illuminate\Database\Seeder;

class RepoTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table("repos")->delete();

        DB::table("repos")->insert([
            "id" => 1,
            "name" => "My TV Program",
            "duedate" => "2015/08/31",
            "path" => "Assignment1Solution.zip",
            "userId" => 1,
            "assignId" => null,
        ]);
		

        DB::table("repos")->insert([
            "id" => 2,
            "name" => "Cheesy Program",
            "duedate" => "2015/09/01",
            "path" => "filepath",
            "userId" => 1,
            "assignId" => 2,
        ]);
    }
}
