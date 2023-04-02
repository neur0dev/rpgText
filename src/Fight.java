public class Fight {

    Dices dices = new Dices();

    public void fight(Player player, Enemy enemy){

        while(player.getHealth() > 0 && enemy.getHealth() > 0){
            playerTurn(player, enemy);
            enemyTurn(player, enemy);
        }
    }


    private void enemyTurn(Player player, Enemy enemy){

        int enemyAttack = dices.rollDice(enemy.getAttackDice(), enemy.getAttackDiceSides());
        if(enemyAttack == 0){
            System.out.println("O " + enemy.getName() + " errou o ataque");
        }

        int playerDefense = dices.rollDice(player.getDefenseDice(), player.getDefenseDiceSides());

        // Damage
        int damage = enemyAttack - playerDefense;
        if(damage > 0){
            player.takeDamage(damage);
            System.out.println("O " + enemy.getName() + " atacou com " + enemyAttack + " e " + player.getName() + " defendeu com " + playerDefense +
                    " e sofreu " + damage + " de dano");
        } else {
            System.out.println("O " + enemy.getName() + " atacou com " + enemyAttack + " e " + player.getName() + " defendeu com " + playerDefense +
                    " e não sofreu dano");
            System.out.println(player.getName() + " tem " + player.getHealth() + " de vida");
        }
    }

    private void playerTurn(Player player, Enemy enemy){
        int playerAttack = dices.rollDice(player.getAttackDice(), player.getAttackDiceSides());
        if(playerAttack == 0){
            System.out.println("O " + player.getName() + " errou o ataque");
        }

        int enemyDefense = dices.rollDice(enemy.getDefenseDice(), enemy.getDefenseDiceSides());

        // Damage
        int damage = playerAttack - enemyDefense;
        if(damage > 0){
            enemy.takeDamage(damage);
            System.out.println("O " + player.getName() + " atacou com " + playerAttack + " e " + enemy.getName() + " defendeu com " + enemyDefense +
                    " e sofreu " + damage + " de dano");
        } else {
            System.out.println("O " + player.getName() + " atacou com " + playerAttack + " e " + enemy.getName() + " defendeu com " + enemyDefense +
                    " e não sofreu dano");
            System.out.println(enemy.getName() + " tem " + enemy.getHealth() + " de vida");
        }
    }

}