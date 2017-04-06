<?php

use Illuminate\Database\Seeder;

class AssignmentTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table("assignments")->delete();
		
        DB::table("assignments")->insert([
            "id" => 1,
            "name" => "TOC - Assignment 1",
            "description" => "Learn to push in the power button",
            "path" => "COMP00001_A1.zip",
            "moduleId" => 2,
        ]);

        DB::table("assignments")->insert([
            "id" => 2,
            "name" => "TOC - Assignment 2",
            "description" => "Learn to release the power button",
            "path" => "COMP00001_A2.zip",
            "moduleId" => 2,
        ]);
    }
}
