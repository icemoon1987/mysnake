///////////////////////////////////////////////////////////
//  SnakeState.h
//  Implementation of the Interface SnakeState
//  Created on:      05-Ê®ÔÂ-2013 11:16:10
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_8E62AA53_9889_4eae_AF18_E160A97BCFBC__INCLUDED_)
#define EA_8E62AA53_9889_4eae_AF18_E160A97BCFBC__INCLUDED_

/**
 * The states of Snake game
 */
class SnakeState
{

public:
	SnakeState() {

	}

	virtual ~SnakeState() {

	}

	virtual void ProcessCmd(const int cmd) =0;

};
#endif // !defined(EA_8E62AA53_9889_4eae_AF18_E160A97BCFBC__INCLUDED_)
