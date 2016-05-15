package mods.hinasch.lib.particle;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.util.EnumParticleTypes;

/** バニラのparticleとこのmodのparticleどちらも包めるラッパー*/
public class ParticleTypeWrapper {


	//public static enum EnumUnsagaParticles {BUBBLE,LEAVES,STONE};
	protected EnumParticleTypes typeVanilla;
	protected EnumUnsagaParticles typeUnsaga;

	public ParticleTypeWrapper(EnumParticleTypes type){
		this.typeVanilla = type;
	}

	public ParticleTypeWrapper(EnumUnsagaParticles type){
		this.typeUnsaga = type;
	}

	public int getParticleID(){
		if(this.typeVanilla!=null){
			return this.typeVanilla.getParticleID();
		}
		if(this.typeUnsaga!=null){
			return typeUnsaga.getParticleID();
		}
		return -1;
	}

	public boolean isVanillaParticle(){
		return this.typeVanilla!=null;
	}

	public static Pair<Integer,Integer> getParticleIndexFromID(int particleID){
		Pair<Integer,Integer> pair = Pair.of(0, 0);
		for(EnumUnsagaParticles type:EnumUnsagaParticles.LOOKUP){
			if(type.getParticleID()==particleID){
				pair = Pair.of(type.getIndexX(),type.getIndexY());
			}
		}
		return pair;
	}


	public static enum EnumUnsagaParticles{
		DUMMY(999,0,0),BUBBLE(200,0,2),LEAVES(201,0,0),STONE(202,1,0),LIGHT(203,2,3);

		private final int particleID;
		private final int indexX;
		private final int indexY;
//		private final int iconMeta;
//		private final String jsonName;
		public static final EnumUnsagaParticles[] LOOKUP;
		static{
			EnumUnsagaParticles[] types = values();
			LOOKUP = new EnumUnsagaParticles[values().length];
			int index = 0;
			for(EnumUnsagaParticles type:types){
				LOOKUP[index] = type;
				index += 1;
			}
		}
		private EnumUnsagaParticles(int id,int x,int y){
			this.particleID = id;
			this.indexX = x;
			this.indexY = y;
//			this.iconMeta = meta;
//			this.jsonName = jsonname;
		}

		public int getParticleID(){
			return this.particleID;
		}
		public int getIndexX(){
			return this.indexX;
		}

		public int getIndexY(){
			return this.indexY;
		}

//		public static String[] getJsonNames(){
//			String[] array1 = new String[LOOKUP.length];
//			int index = 0;
//			for(EnumUnsagaParticles type:LOOKUP){
//				array1[index] = type.getJsonName();
//				index+=1;
//			}
//			return array1;
//
//		}

	}
}
