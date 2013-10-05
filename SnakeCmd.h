///////////////////////////////////////////////////////////
//  SnakeCmd.h
//  Implementation of the Class SnakeCmd
//  Created on:      05-Ê®ÔÂ-2013 11:16:08
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_CD93E1C3_3771_4139_BF18_DFB55F84048C__INCLUDED_)
#define EA_CD93E1C3_3771_4139_BF18_DFB55F84048C__INCLUDED_

#include "SnakeCore.h"

/**
 * Commands for Snake
 */
enum SnakeCmd
{
	CMD_START,
	CMD_UP,
	CMD_DOWN,
	CMD_RIGHT,
	CMD_LEFT,
	CMD_PAUSE,
	SnakeCore *m_SnakeCore;
};
#endif // !defined(EA_CD93E1C3_3771_4139_BF18_DFB55F84048C__INCLUDED_)
