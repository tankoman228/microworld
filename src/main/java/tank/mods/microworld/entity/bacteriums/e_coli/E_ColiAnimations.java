package tank.mods.microworld.entity.bacteriums.e_coli;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;

public class E_ColiAnimations {

public static final AnimationDefinition ROTATE = AnimationDefinition.Builder.withLength(2f)
.addAnimation("Central",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1f, KeyframeAnimations.posVec(0f, 2f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("Central",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 180f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 360f),
			AnimationChannel.Interpolations.LINEAR))).build();
public static final AnimationDefinition DIVIDE = AnimationDefinition.Builder.withLength(1.5834333f)
.addAnimation("bone1",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.0416767f, KeyframeAnimations.posVec(0f, 0f, 3f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.5834333f, KeyframeAnimations.posVec(0f, 0f, 3.7f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bone1",
	new AnimationChannel(AnimationChannel.Targets.SCALE,
		new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 0.9f, 1f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1f, 1f, 0.7f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bone2",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 0f, -2f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.0416767f, KeyframeAnimations.posVec(0f, 0f, -4f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(1.5834333f, KeyframeAnimations.posVec(0f, 0f, -4f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("bone2",
	new AnimationChannel(AnimationChannel.Targets.SCALE,
		new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 0.1f, 1f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.20834334f, KeyframeAnimations.scaleVec(1f, 1f, 0.6f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1f, 1f, 0.7f),
			AnimationChannel.Interpolations.LINEAR))).build();
}
