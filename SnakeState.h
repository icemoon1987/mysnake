///////////////////////////////////////////////////////////
//  SnakeState.h
//  Implementation of the Interface SnakeState
//  Created on:      05-Ê®ÔÂ-2013 18:14:19
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_39F43B31_CA30_43be_91EE_92E71008BA5F__INCLUDED_)
#define EA_39F43B31_CA30_43be_91EE_92E71008BA5F__INCLUDED_

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
#endif // !defined(EA_39F43B31_CA30_43be_91EE_92E71008BA5F__INCLUDED_)
