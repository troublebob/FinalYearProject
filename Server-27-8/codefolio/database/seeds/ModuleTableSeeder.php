<?php

use Illuminate\Database\Seeder;

class ModuleTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table("modules")->delete();
		DB::table("modules")->insert([
			"id"=> 1,
			"code"=> "Personal Repos",
			"description" => "Unassigned Repositories",
			"lecturer" => "All users",
		]);
        DB::table("modules")->insert([
            "id" => 2,
            "code" => "COMP00001",
            "description" => "Turning on computers",
            "lecturer" => "Dr. M.T. Inside",
        ]);

        DB::table("modules")->insert([
            "id" => 3,
            "code" => "COMP00002",
            "description" => "Turning off computers",
            "lecturer" => "Dr. M.T. Outside",
        ]);
    }
}
