<?php

use Illuminate\Database\Seeder;
use Illuminate\Database\Eloquent\Model;

class DatabaseSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Model::unguard();

        $this->call(UserTableSeeder::class);
        $this->call(ModuleTableSeeder::class);
        $this->call(UserModuleTableSeeder::class);
        $this->call(AssignmentTableSeeder::class);
        $this->call(RepoTableSeeder::class);
        $this->call(CommentTableSeeder::class);

        Model::reguard();
    }
}
