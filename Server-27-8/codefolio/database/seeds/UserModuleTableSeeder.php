<?php

use Illuminate\Database\Seeder;

class UserModuleTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table("user_modules")->delete();

        DB::table("user_modules")->insert([
            "userId" => 1,
            "moduleId" => 1,
        ]);

        DB::table("user_modules")->insert([
            "userId" => 2,
            "moduleId" => 1,
        ]);
    }
}
