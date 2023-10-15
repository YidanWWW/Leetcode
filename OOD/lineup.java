import java.util.*;

public class LineupFactory {
    /// <summary>
    /// Determines whether the given lineup is valid
    /// </summary>
    /// <param name="contest">The contest for which the given lineup has been submitted</param>
    /// <param name="lineup">The list of players on a fantasy team</param>
    /// <returns>Whether the lineup is valid according to the given rules</returns>
    public boolean validLineup(Contest contest, List<TeamPlayer> lineup) {
        //null check?
        //The sum of player salary can not exceed the contests max salary cap
        int salarySum = 0;
        for(TeamPlayer player : lineup) {
            salarySum += player.getPlayer().getSalary();
            if(salarySum > contest.maximumSalaryCap) return false;
        }
        
        
        // Any single player can only be used once
        //hashset to store used player
        Set<Integer> playerIdSet = new HashSet<>();
        for(TeamPlayer player : lineup) {
            int playerId = player.getPlayer().getId();
            if(!playerIdSet.contains(playerId)) return false;
            playerIdSet.add(playerId);
        }
        
        // The lineup can not contain more than the required amount of players
        
        // 2 hashmap: reqPositions, actualPositions, compare them
        Map<FantasyPosition, Integer> reqPostionsMap = contest.getRosterPositionCount();
        Map<FantasyPosition, Integer> acutalPositionsMap = new HashMap<>();
        for(TeamPlayer player : lineup) {
            FantasyPosition position = player.getFantasyPosition();
            acutalPositionsMap.put(position, acutalPositionsMap.getOrDefault(position, 0)+1); //key: positon, value:count of this positon
        }
        
        //compare these two positions' count
        for(FantasyPosition position : acutalPositionsMap.keySet()) {
            if(!reqPostionsMap.containsKey(position) || reqPostionsMap.get(position)<acutalPositionsMap.get(position)) return false;
        }
        
        
        // There can not be more than 3 players on a single team
        Map<Integer, Integer> playerCountMap = new HashMap<>(); //key:teamId, value: count of this player in this team
        for(TeamPlayer player : lineup) {
            int teamId = player.getPlayer().getTeamId();
            playerCountMap.put(teamId, playerCountMap.getOrDefault(teamId, 0)+1);
            if(playerCountMap.get(teamId)>3) return false;
        }
        
        
        //The lineup must encompass at least two games
        //HashSet to store nextGameId, then check hashset's size
        HashSet<Integer> gameIdsSet = new HashSet<>();
        for(TeamPlayer player : lineup){
            int nextGameId = player.getPlayer().getNextGameId();
            gameIdsSet.add(nextGameId);
        }
        if(gameIdsSet.size()<2) return false;
        
        // All roster positions listed in the contest must be filled by the lineup
        Set<TeamPosition> filledPositionsSet = new HashSet<>();
        for(TeamPlayer player : lineup) {
            filledPositionsSet.add(player.getPlayer().getPosition());
        } 
        
        for(FantasyPosition position : reqPostionsMap.keySet()) {
            List<TeamPosition> list = position.getAllowedPositions();
            if(!filledPositionsSet.containsAll(list)) return false;
        }
        return true;
        
        
        
    }
       
    public class Contest {
        private Map<FantasyPosition, Integer> rosterPositionCount;
        private int maximumSalaryCap;
        private int id;
    
        public Contest(Map<FantasyPosition, Integer> rosterPositionCount, int maximumSalaryCap, int id) {
            this.rosterPositionCount = rosterPositionCount;
            this.maximumSalaryCap = maximumSalaryCap;
            this.id = id;
        }
        
        public Map<FantasyPosition, Integer> getRosterPositionCount() {
            return rosterPositionCount;
        }
        public void setRosterPositionCount( Map<FantasyPosition, Integer> rosterPositionCount) {
            this.rosterPositionCount = rosterPositionCount;
        }
        public int getMaximumSalaryCap() {
            return maximumSalaryCap;
        }
        public void setMaximumSalaryCap(int maximumSalaryCap) {
            this.maximumSalaryCap = maximumSalaryCap;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
    }
        
    public class TeamPlayer {
        private FantasyPosition fantasyPosition;
        private Player player;
    
        public FantasyPosition getFantasyPosition() {
            return fantasyPosition;
        }
        public void setFantasyPosition(FantasyPosition fantasyPosition) {
            this.fantasyPosition = fantasyPosition;
        }
        public Player getPlayer() {
            return player;
        }
        public void setPlayer(Player player) {
            this.player = player;
        }
    }
   
    public class Player {
        private int id;
        private TeamPosition position;
        private int teamId;
        private int nextGameId;
        private int salary;
        private int avgPointsPerGame;
    
        public Player(int id, TeamPosition position, int teamId, int nextGameId, int salary, int avgPointsPerGame) {
            this.id = id;
            this.position = position;
            this.teamId = teamId;
            this.nextGameId = nextGameId;
            this.salary = salary;
            this.avgPointsPerGame = avgPointsPerGame;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public TeamPosition getPosition() {
            return position;
        }
        public void setPosition(TeamPosition position) {
            this.position = position;
        }
        public int getTeamId() {
            return teamId;
        }
        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }
        public int getNextGameId() {
            return nextGameId;
        }
        public void setNextGameId(int nextGameId) {
            this.nextGameId = nextGameId;
        }
        public int getSalary() {
            return salary;
        }
        public void setSalary(int salary) {
            this.salary = salary;
        }
        public int getAvgPointsPerGame() {
            return avgPointsPerGame;
        }
        public void setAvgPointsPerGame(int avgPointsPerGame) {
            this.avgPointsPerGame = avgPointsPerGame;
        }
    }   

    public class FantasyPosition {
        private List<TeamPosition> allowedPositions;
        private String name;
        private int id;
    
        public FantasyPosition(List<TeamPosition> allowedPositions, String name, int id) {
            this.allowedPositions = allowedPositions;
            this.name = name;
            this.id = id;
        }
        public List<TeamPosition> getAllowedPositions() {
            return allowedPositions;
        }
        public void setAllowedPositions(List<TeamPosition> allowedPositions) {
            this.allowedPositions = allowedPositions;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }      
    }
        
    public class TeamPosition {
        private String name;
        private int id;
    
        public TeamPosition(String name, int id) {
            this.name = name;
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
    }       
}
