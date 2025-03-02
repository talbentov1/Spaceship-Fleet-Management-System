package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;



public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		Comparator<Spaceship> com=new mySpaceShipComparator();
		List<Spaceship> fleetlst= new ArrayList<>(fleet);
		Collections.sort(fleetlst,com);
		List<String> stringlst= new ArrayList<>();
		for (Spaceship s : fleetlst){
			stringlst.add(s.toString());
		}
		return stringlst;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String,Integer> hm= new HashMap<>();
		for (Spaceship s : fleet){
			hm.put(s.getClass().getSimpleName(),0);
		}
		for (Spaceship s : fleet){
			hm.put(s.getClass().getSimpleName(),hm.get(s.getClass().getSimpleName())+1);
		}
		return hm;
	}

	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum=0;
		for (Spaceship s : fleet){
			sum+=s.getAnnualMaintenanceCost();
		}
		return sum;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weapons= new HashSet<>();
		for (Spaceship s : fleet){
			if (!(s instanceof TransportShip)){
				mygetWeaponAndFirePower m=(mygetWeaponAndFirePower) s;
				for (Weapon w : m.getWeapon()){
					weapons.add(w.getName());
				}
			}
		}
		return weapons;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int sum=0;
		for (Spaceship s : fleet){
			sum+=s.getCrewMembers().size();
		}
		return sum;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int sum=0, cnt=0;
		for (Spaceship s : fleet){
			for (CrewMember c : s.getCrewMembers()){
				if (c instanceof Officer){
					sum+=c.getAge();
					cnt++;
				}
			}
		}
		return (float) sum/cnt;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> map=new HashMap<>();
		for (Spaceship s : fleet){
			OfficerRank maxRank=OfficerRank.Ensign;
			Officer HighestRankingOfficer = null;
			for (CrewMember c : s.getCrewMembers()){
				if (c instanceof Officer){
					OfficerRank tmp=((Officer) c).getRank();
					if(tmp.compareTo(maxRank)>0){
						maxRank=tmp;
						HighestRankingOfficer=(Officer) c;
					}
				}
			}
			if (HighestRankingOfficer!=null) {
				map.put(HighestRankingOfficer, s);
			}
		}
		return map;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> RankInstances = new HashMap<>();
		for (OfficerRank rank : OfficerRank.values()) {
			RankInstances.put(rank, 0);
		}
		for (Spaceship s : fleet) {
			for (CrewMember c : s.getCrewMembers()) {
				if (c instanceof Officer) {
					RankInstances.put(((Officer) c).getRank(), RankInstances.get(((Officer) c).getRank())+1);
				}
			}
		}
		RankInstances.values().removeIf(integer -> integer == 0);
		List<Map.Entry<OfficerRank, Integer>> RankList=new ArrayList<>(RankInstances.entrySet());
		Comparator<Map.Entry<OfficerRank, Integer>> comparator= new Comparator<Map.Entry<OfficerRank, Integer>>() {
			@Override
			public int compare(Map.Entry<OfficerRank, Integer> o1, Map.Entry<OfficerRank, Integer> o2) {
				int num=Integer.compare(o1.getValue(), o2.getValue());
				if (num!=0){
					return num;
				}
				return o1.getKey().compareTo(o2.getKey());
			}
		};
		Collections.sort(RankList,comparator);
		return RankList;
	}

	}
