import java.util.Random;

public class Dungeon {
    private SaraDaisyChainConnector rooms;
    private Box currentBox;
    private Player player;
    private Random random;

    public Dungeon(Player player) {
        this.player = player;
        this.random = new Random();
        generateRooms();
        this.currentBox = rooms.getHead();
    }

    public void moveToNextLevel() {
        player.ageUp();
        generateRooms();
        this.currentBox = rooms.getHead();
    }
    
    public void setCurrentRoom(Box curr){
        this.currentBox = curr;
        enterCurrentRoom();
    }
    
    public void enteredCurrentBox(Box curr){
        rooms.remove(currentBox);
    }

    public void enterCurrentRoom() {
        if (currentBox != null) {
            Room currentRoom = currentBox.getRoom();
            if (currentRoom != null) {
                currentRoom.enter(player);
            }
        }
        
    }

    private void generateRooms() {
        this.rooms = new SaraDaisyChainConnector();
        this.rooms.add(new StartingRoom());
        player.resetSkipCount();
        player.gainWisdom(5);

        for (int i = 1; i < 12; i++) {
            Room room = generateRandomRoomForAgeGroup(player.getAge());
            this.rooms.add(room);
        }

        int exitRoomIndex = random.nextInt(10) + 2;
        Box exitRoomBox = this.rooms.get(exitRoomIndex);
        if (exitRoomBox != null && exitRoomBox.getRoom() != null) {
            exitRoomBox.getRoom().setItem(new AgeGroupTreasure("Exit"));
        }
    }

    private Room generateRandomRoomForAgeGroup(int age) {
        int roomType = random.nextInt(3); 

        switch (roomType) {
            case 0:
                return new TreasureRoom(generateAgeSpecificTreasure(age));
            case 1:
                return new TrapRoom(generateAgeSpecificTrap(age));
            case 2:
                return new MonsterRoom(generateAgeSpecificMonster(age));
            default:
                return null;
        }
    }

    public AgeGroupTreasure generateAgeSpecificTreasure(int age) {
    int hapEffect = Math.max(1, random.nextInt(10) + 1 - (age / 10)); 
    int energyEffect = Math.max(1, random.nextInt(5) + 1 - (age / 15)); 

    switch (ageGroup(age)) {
        case "Infant":
            switch (random.nextInt(3)) {
                case 0: return new AgeGroupTreasure("Milk", hapEffect, energyEffect, "Infant");
                case 1: return new AgeGroupTreasure("Your First Word", hapEffect, energyEffect, "Infant");
                case 2: return new AgeGroupTreasure("Your Blankey", hapEffect, energyEffect, "Infant");
            }
        case "Toddler":
            switch (random.nextInt(3)) {
                case 0: return new AgeGroupTreasure("Learning to Walk", hapEffect, energyEffect, "Toddler");
                case 1: return new AgeGroupTreasure("Favorite Snack", hapEffect, energyEffect, "Toddler");
                case 2: return new AgeGroupTreasure("Bedtime Story", hapEffect, energyEffect, "Toddler");
            }
        case "Child":
            switch (random.nextInt(3)) {
                case 0: return new AgeGroupTreasure("Perfect Report Card", hapEffect, energyEffect, "Child");
                case 1: return new AgeGroupTreasure("New Best Friend", hapEffect, energyEffect, "Child");
                case 2: return new AgeGroupTreasure("Birthday Party", hapEffect, energyEffect, "Child");
            }
        case "Teenager":
            switch (random.nextInt(3)) {
                case 0: return new AgeGroupTreasure("Making the Soccer Team", hapEffect, energyEffect, "Teenager");
                case 1: return new AgeGroupTreasure("First Crush", hapEffect, energyEffect, "Teenager");
                case 2: return new AgeGroupTreasure("Driver's License", hapEffect, energyEffect, "Teenager");
            }
        case "Young Adult":
            switch (random.nextInt(3)) {
                case 0: return new AgeGroupTreasure("College Degree", hapEffect, energyEffect, "Young Adult");
                case 1: return new AgeGroupTreasure("Gym Sesh", hapEffect, energyEffect, "Young Adult");
                case 2: return new AgeGroupTreasure("New Job", hapEffect, energyEffect, "Young Adult");
            }
        case "Adult":
            switch (random.nextInt(3)) {
                case 0: return new AgeGroupTreasure("Promotion", hapEffect, energyEffect, "Adult");
                case 1: return new AgeGroupTreasure("Vacation", hapEffect, energyEffect, "Adult");
                case 2: return new AgeGroupTreasure("Marriage", hapEffect, energyEffect, "Adult");
            }
        case "Elderly":
            switch (random.nextInt(3)) {
                case 0: return new AgeGroupTreasure("Retirement", hapEffect, energyEffect, "Elderly");
                case 1: return new AgeGroupTreasure("Grandchildren", hapEffect, energyEffect, "Elderly");
                case 2: return new AgeGroupTreasure("Photobook", hapEffect, energyEffect, "Elderly");
            }
        default:
            return new AgeGroupTreasure("Default Treasure", hapEffect, energyEffect, "General");
    }
}


    public AgeGroupTrap generateAgeSpecificTrap(int age) {
        int energyLoss = random.nextInt(5) + 3 + (age / 10);
        int happinessLoss = random.nextInt(4) + 2 + (age / 10);

        switch (ageGroup(age)) {
            case "Infant":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupTrap("Teething Pain", energyLoss, happinessLoss, "Infant");
                    case 1: return new AgeGroupTrap("Being Confined to Your Crib", energyLoss, happinessLoss, "Infant");
                    case 2: return new AgeGroupTrap("a Diaper Rash", energyLoss, happinessLoss, "Infant");
                }
            case "Toddler":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupTrap("Falling Down", energyLoss, happinessLoss, "Toddler");
                    case 1: return new AgeGroupTrap("Timeouts", energyLoss, happinessLoss, "Toddler");
                    case 2: return new AgeGroupTrap("TRAP", energyLoss, happinessLoss, "Toddler");
                }
            case "Child":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupTrap("Being Left Out", energyLoss, happinessLoss, "Child");
                    case 1: return new AgeGroupTrap("Lost Toy", energyLoss, happinessLoss, "Child");
                    case 2: return new AgeGroupTrap("Fight with Sibling", energyLoss, happinessLoss, "Child");
                }
            case "Teenager":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupTrap("Detention", energyLoss, happinessLoss, "Teenager");
                    case 1: return new AgeGroupTrap("a Failed Exam", energyLoss, happinessLoss, "Teenager");
                    case 2: return new AgeGroupTrap("Drama with Friends", energyLoss, happinessLoss, "Teenager");
                }
            case "Young Adult":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupTrap("Overtime", energyLoss, happinessLoss, "Young Adult");
                    case 1: return new AgeGroupTrap("a Break Up", energyLoss, happinessLoss, "Young Adult");
                    case 2: return new AgeGroupTrap("Rent", energyLoss, happinessLoss, "Young Adult");
                }
            case "Adult":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupTrap("a Midlife Crisis", energyLoss, happinessLoss, "Adult");
                    case 1: return new AgeGroupTrap("Road Rage", energyLoss, happinessLoss, "Adult");
                    case 2: return new AgeGroupTrap("an Overbearing In-Law", energyLoss, happinessLoss, "Adult");
                }
            case "Elderly":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupTrap("Loneliness", energyLoss, happinessLoss, "Elderly");
                    case 1: return new AgeGroupTrap("Arthritis", energyLoss, happinessLoss, "Elderly");
                    case 2: return new AgeGroupTrap("Falling Down and Not Being Able to Get Back Up", energyLoss, happinessLoss, "Elderly");
                }
            default:
                return new AgeGroupTrap("Default Trap", 5, 5, "General");
        }
    }

    public AgeGroupMonster generateAgeSpecificMonster(int age) {
        int healthLoss = random.nextInt(8) + 3 + (age / 10);
        int energyLoss = random.nextInt(5) + 3 + (age / 10);
        int wisdom = random.nextInt(5) + 3 + (age / 5);
        int maxTurns = random.nextInt(3) + 2 + (age / 20);

        switch (ageGroup(age)) {
            case "Infant":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupMonster("a Bad Babysitter", energyLoss, wisdom, healthLoss, maxTurns, "Infant");
                    case 1: return new AgeGroupMonster("Peek-a-Boo Overload", energyLoss, wisdom, healthLoss, maxTurns, "Infant");
                    case 2: return new AgeGroupMonster("a Tickle Attack", energyLoss, wisdom, healthLoss, maxTurns, "Infant");
                }
            case "Toddler":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupMonster("Potty Training", energyLoss, wisdom, healthLoss, maxTurns, "Toddler");
                    case 1: return new AgeGroupMonster("the Monster Under the Bed", energyLoss, wisdom, healthLoss, maxTurns, "Toddler");
                    case 2: return new AgeGroupMonster("Broccoli", energyLoss, wisdom, healthLoss, maxTurns, "Toddler");
                }
            case "Child":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupMonster("a Mean Teacher", energyLoss, wisdom, healthLoss, maxTurns, "Child");
                    case 1: return new AgeGroupMonster("a Playground Bully", energyLoss, wisdom, healthLoss, maxTurns, "Child");
                    case 2: return new AgeGroupMonster("the Times Tables", energyLoss, wisdom, healthLoss, maxTurns, "Child");
                }
            case "Teenager":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupMonster("your Ex Boyfriend/Girlfriend", energyLoss, wisdom, healthLoss, maxTurns, "Teenager");
                    case 1: return new AgeGroupMonster("Puberty", energyLoss, wisdom, healthLoss, maxTurns, "Teenager");
                    case 2: return new AgeGroupMonster("your Helicopter Parents", energyLoss, wisdom, healthLoss, maxTurns, "Teenager");
                }
            case "Young Adult":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupMonster("Boss Problems", energyLoss, wisdom, healthLoss, maxTurns, "Young Adult");
                    case 1: return new AgeGroupMonster("a Bad Tinder Date", energyLoss, wisdom, healthLoss, maxTurns, "Young Adult");
                    case 2: return new AgeGroupMonster("Student Loans", energyLoss, wisdom, healthLoss, maxTurns, "Young Adult");
                }
            case "Adult":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupMonster("a Karen Neighbor", energyLoss, wisdom, healthLoss, maxTurns, "Adult");
                    case 1: return new AgeGroupMonster("Office Rival", energyLoss, wisdom, healthLoss, maxTurns, "Adult");
                    case 2: return new AgeGroupMonster("Ex-Spouse", energyLoss, wisdom, healthLoss, maxTurns, "Adult");
                }
            case "Elderly":
                switch (random.nextInt(3)) {
                    case 0: return new AgeGroupMonster("Forgetful Moments", energyLoss, wisdom, healthLoss, maxTurns, "Elderly");
                    case 1: return new AgeGroupMonster("Wheelchair Dependency", energyLoss, wisdom, healthLoss, maxTurns, "Elderly");
                    case 2: return new AgeGroupMonster("Gray Hairs", energyLoss, wisdom, healthLoss, maxTurns, "Elderly");
                }
            default:
                return new AgeGroupMonster("Default Monster", 5, 5, 5, 3, "General");
        }
    }

    private String ageGroup(int age) {
        if (age <= 1) return "Infant";
        if (age <= 5) return "Toddler";
        if (age <= 12) return "Child";
        if (age <= 19) return "Teenager";
        if (age <= 30) return "Young Adult";
        if (age <= 60) return "Adult";
        return "Elderly";
    }

    public SaraDaisyChainConnector getRooms() {
        return rooms;
    }
}
