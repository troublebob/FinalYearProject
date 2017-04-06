<?php

use Illuminate\Database\Seeder;

class UserTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table("users")->delete();

        DB::table("users")->insert([
            "id" => 1,
            "name" => "Rob",
            "email" => "rob@ucd.ie",
            "password" => Hash::make("wordpass"),
        ]);

        DB::table("users")->insert([
            "id" => 2,
            "name" => "Rem",
            "email" => "rem@ucd.ie",
            "password" => Hash::make("wordpass"),
        ]);
    }
}
